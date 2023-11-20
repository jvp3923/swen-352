import unittest
from unittest.mock import Mock, call
from library.library_db_interface import Library_DB

class TestLibbraryDBInterface(unittest.TestCase):

    def setUp(self):
        self.db_interface = Library_DB()
        self.db_interface.db = Mock()
        self.patron = Mock()
        self.patron1_json = {
        "lname": "Sam",
        "fname": "Edgar",
        "age": 10,
        "memberID": 1,
        "borrowed_books": 5
    }
        
    def test_database_file(self):
        self.assertEqual(Library_DB.DATABASE_FILE, 'db.json')
    
    def test_update_patron_uses_correct_memberID(self):
        patron_mock = Mock()
        patron_id = 1
        patron_mock.get_memberID.return_value = patron_id
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': patron_id,
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)

        db_data = [
            {"memberID": patron_id, "updated": False},
            {"memberID": 2, "updated": False}
        ]

        def mock_search(condition):
            return [record for record in db_data if condition(record)]

        def mock_update(new_data, condition):
            for record in db_data:
                if condition(record):
                    record["updated"] = True

        self.db_interface.db.search = mock_search
        self.db_interface.db.update = mock_update

        self.db_interface.update_patron(patron_mock)

        matching_record = next(record for record in db_data if record["memberID"] == patron_id)
        non_matching_record = next(record for record in db_data if record["memberID"] != patron_id)

        self.assertTrue(matching_record["updated"], "Expected record with matching memberID to be updated")
        self.assertFalse(non_matching_record["updated"], "Did not expect record with non-matching memberID to be updated")

    def test_insert_patron_not_in_db(self):
        patron_mock = Mock()
        self.db_interface.retrieve_patron = Mock(return_value=None)
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.db.insert = Mock(side_effect=lambda x: 10 if x==data else 0)
        self.assertEqual(self.db_interface.insert_patron(patron_mock), 10)

    def test_insert_exisiting_patron(self):
        self.patron.retrieve_patron.return_value = 0 
        self.db_interface.db.search.return_value = [self.patron1_json]
        
        self.assertIsNone(self.db_interface.insert_patron(self.patron))
        assert self.db_interface.db.search.called

    def test_insert_Null_patron(self):
        self.assertIsNone(self.db_interface.insert_patron(None))
        self.db_interface.db.search.assert_not_called()

    def test_insert_new_patron(self):
        patron_data = self.patron1_json
        self.patron.retrieve_patron.return_value = patron_data["memberID"]

        self.db_interface.db.search.return_value = None
        self.db_interface.db.insert.return_value = patron_data["memberID"]
        
        self.patron.get_lname.return_value = patron_data["lname"]
        self.patron.get_fname.return_value = patron_data["fname"]
        self.patron.get_age.return_value = patron_data["age"]
        self.patron.get_memberID.return_value = patron_data["memberID"]
        self.patron.get_borrowed_books.return_value = patron_data["borrowed_books"]

        self.assertEqual(self.db_interface.insert_patron(self.patron),patron_data["memberID"])
        self.db_interface.db.insert.assert_called_once_with(patron_data)
        self.db_interface.db.search.assert_called()

    def test_update_patron(self):
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        db_update_mock = Mock()
        self.db_interface.db.update = db_update_mock
        self.db_interface.update_patron(Mock())
        db_update_mock.assert_called()
    
    def test_update_null_patron(self):
        self.assertIsNone(self.db_interface.update_patron(None))

    def test_get_all_patrons(self):
        
        self.db_interface.db.all.return_value = [self.patron1_json]
        
        self.assertEqual(self.db_interface.get_all_patrons(),[self.patron1_json])


    def test_get_all_patrons_count(self):
        
        self.db_interface.db.all.return_value = [self.patron1_json]
        
        self.assertEqual(self.db_interface.get_patron_count(),len([self.patron1_json]))

    def test_convert_patron_to_db_format(self):
        patron_mock = Mock()

        patron_mock.get_fname = Mock(return_value=1)
        patron_mock.get_lname = Mock(return_value=2)
        patron_mock.get_age = Mock(return_value=3)
        patron_mock.get_memberID = Mock(return_value=4)
        patron_mock.get_borrowed_books = Mock(return_value=5)
        self.assertEqual(self.db_interface.convert_patron_to_db_format(patron_mock),
                         {'fname': 1, 'lname': 2, 'age': 3, 'memberID': 4,
                          'borrowed_books': 5})
