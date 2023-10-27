import unittest
from library import patron

class TestPatron(unittest.TestCase):

    def setUp(self):
        self.pat = patron.Patron('fname', 'lname', '20', '1234')

    def test_age_exists(self):
        self.pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertIsNotNone(self.pat.age)

    def test_valid_name(self):
        pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(isinstance(pat, patron.Patron))

    def test_invalid_name(self):
        self.assertRaises(patron.InvalidNameException, patron.Patron, '1fname', '1lname', '20', '1234')

    def test_valid_age(self):
        pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(isinstance(pat, patron.Patron))

    def test_valid_memberID(self):
        pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(isinstance(pat, patron.Patron))

    def test_add_borrowed_book(self):
        self.pat.add_borrowed_book('book')
        self.assertEqual(self.pat.borrowed_books, ['book'])
    
    def test_add_borrowed_book_duplicate(self):
        self.pat.add_borrowed_book('book')
        self.pat.add_borrowed_book('book')
        self.assertEqual(self.pat.borrowed_books, ['book'])
    
    def test_get_borrowed_books(self):
        self.pat.add_borrowed_book('book')
        self.assertEqual(self.pat.get_borrowed_books(), ['book'])
    
    def test_return_borrowed_book(self):
        self.pat.add_borrowed_book('book')
        self.pat.return_borrowed_book('book')
        self.assertEqual(self.pat.borrowed_books, [])
    
    def test_return_borrowed_book_not_borrowed(self):
        self.pat.return_borrowed_book('book')
        self.assertEqual(self.pat.borrowed_books, [])

    def test_eq(self):
        pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(self.pat == pat)
