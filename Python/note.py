import json
from datetime import datetime
from typing import Any


class Note:

    def __init__(self, header, body):
        self.header = header
        self.body = body
        self.datetime = str(datetime.now())



    def __str__(self):
        return f"Header: {self.header}\nBody: {self.body}\nCreate date: {self.datetime}"

    def __setattr__(self, __name: str, __value: Any) -> None:
        super().__setattr__(__name, __value)


class CustomEncoder(json.JSONEncoder):
    def default(self, o):
        return o.__dict__
