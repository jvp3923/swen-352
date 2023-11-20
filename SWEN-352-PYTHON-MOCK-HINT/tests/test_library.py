import unittest
from unittest.mock import Mock

from library.library_db_interface import Library_DB
from library import library, patron
import json

class TestLibrary(unittest.TestCase):

    def setUp(self):
        self.lib = library.Library()

        # self.books_data = [{'title': 'Learning Python', 'ebook_count': 3}, {'title': 'Learning Python (Learning)', 'ebook_count': 1}, {'title': 'Learning Python', 'ebook_count': 1}, {'title': 'Learn to Program Using Python', 'ebook_count': 1}, {'title': 'Aprendendo Python', 'ebook_count': 1}, {'title': 'Python Basics', 'ebook_count': 1}]
        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())

    def test_constructor_db(self):
        self.assertEqual(self.lib.db.__class__, Library_DB) 

    def test_is_ebook_true(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertTrue(self.lib.is_ebook('learning python'))
    
    def test_is_ebook_false(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertFalse(self.lib.is_ebook('How to cook bbq'))

    def test_get_ebooks_count(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertEqual(self.lib.get_ebooks_count("learning python"), 8)

    def test_is_book_by_not_author(self):
        self.lib.api.books_by_author = Mock(return_value=["not the book"])
        self.assertFalse(self.lib.is_book_by_author("bob", "learning python"))

    def test_is_book_by_author(self):
        self.lib.api.books_by_author = Mock(return_value=["learning python"])
        self.assertTrue(self.lib.is_book_by_author("bob", "learning python"))
    
    def test_get_languages_for_book(self):
        self.lib.api.get_book_info = Mock(return_value=[{
            "language": "f"
        }])
        self.assertEqual(self.lib.get_languages_for_book("learning python"), {"f"})

    def test_register_patron(self):
        self.assertEqual(self.lib.register_patron("Ben", "Dover", 69, 420), None)

    def test_register_patron_valid(self):
        fname, lname, age, memberID = "Ben", "Dover", 69, 420

        insert_patron_args = []

        def mock_insert_patron(p):
            insert_patron_args.append(p)
            return None
        
        self.lib.db.insert_patron = mock_insert_patron

        self.lib.register_patron(fname, lname, age, memberID)

        inserted_patron = insert_patron_args[0]
        self.assertIsInstance(inserted_patron, patron.Patron)
        self.assertEqual(inserted_patron.fname, fname)
        self.assertEqual(inserted_patron.lname, lname)
        self.assertEqual(inserted_patron.age, age)
        self.assertEqual(inserted_patron.memberID, memberID)

    def test_is_patron_registered(self):
        pat = patron.Patron('Ben', 'Dover', 69, 420)
        self.assertTrue(self.lib.is_patron_registered(pat))

    def test_patron_not_registered(self):
        pat = patron.Patron('Ben', 'Dover', 69, 420)
        self.lib.db.retrieve_patron = Mock(return_value=None)
        self.assertFalse(self.lib.is_patron_registered(pat))
        
    def test_borrow_book(self):
        pat = patron.Patron('Ben', 'Dover', 69, 420)
        self.lib.borrow_book('learning python', pat)
        self.assertTrue(self.lib.is_book_borrowed('learning python', pat))

    def test_return_borrowed_book(self):
        pat = patron.Patron('Ben', 'Dover', 70, 420)
        self.lib.borrow_book('learning python', pat)
        self.lib.return_borrowed_book('learning python', pat)
        self.assertFalse(self.lib.is_book_borrowed('learning python', pat))


        