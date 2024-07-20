from flask import Flask, render_template
from flask_sqlalchemy import SQLAlchemy
from datetime import datetime

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///test.db'
db = SQLAlchemy(app)

# note: /// refers relative path while //// refers absolute path     

class Todo(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    content = db.Column(db.String(225), nullable=False )
    date_time = db.Column(db.DateTime, default=datetime.now())


    def __repr__(self):
        return '<Task %r>' % self.id
    
def create_app():
    app = Flask(__name__)
    app.config.from_object("project.config")

    with app.app_context():
        db.create_all()

    return app




@app.route('/')
def index():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)