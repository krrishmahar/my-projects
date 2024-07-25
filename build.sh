#!/bin/bash

# Install dependencies
pip install -r requirements.txt

# Run database migrations
flask db upgrade

# Compile translations
flask translate compile

# Run the application
gunicorn microblog:app
