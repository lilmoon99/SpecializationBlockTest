import json
from typing import Any
from note import Note
from note import CustomEncoder


class Notebook:

    def __init__(self):
        self.list = list()

    def add_note(self, note):
        self.list.append(note)
        self.save_notebook()

    def remove_note(self, note):
        self.list.remove(note)
        self.save_notebook()

    def show_notes(self):
        for x in self.list:
            print(x)

    def save_notebook(self):
        with open("data.json", "w") as file:
            json.dump(self.list, file, cls=CustomEncoder)

    def load_notebook(self):
        with open("data.json", "r") as file:
            json_input = json.load(file)
            dict_keys = json_input[0].keys()
            for x in range(len(json_input)):
                temp_note = Note(None, None)
                for y in dict_keys:
                    temp_note.__setattr__(y, json_input[x][y])
                self.add_note(temp_note)
