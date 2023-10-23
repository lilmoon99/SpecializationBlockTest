# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import json
from note import Note
from notebook import Notebook
from datetime import datetime

# json_data = json.dumps(data, sort_keys=True, indent=4)
# print(json_data)

# with open('data.json', 'w') as file:
#     json.dump(data, file)
note1 = Note("Header", "Body", )
# notebook.show_notes()
note2 = Note("Header2", "Body2")
notebook = Notebook()
# notebook.add_note(note1)
# notebook.add_note(note2)
# notebook.show_notes()
notebook.load_notebook()
notebook.show_notes()