A simple console-based task manager written in Java.
This project allows users to add tasks, mark them as completed, remove them, and save automatically in a local text file.

This project was created to practice:

Object-Oriented Programming (OOP)
File I/O in Java (FileWriter, FileReader, BufferedReader)
ArrayList usage
Input validation
Clean code and error handling

Features

✔ Add tasks
✔ Mark tasks as completed / not completed
✔ Remove tasks
✔ View task list
✔ Data persistence — tasks are saved to task.txt and loaded on startup
✔ Input validation (prevents invalid entries)

Tech Stack

Category	Technology
Language	Java
Project Type	Console application
Data Storage	Text file (task.txt)
Concepts	OOP, File I/O, Validation, Collections

Project Structure
TaskManager/
 ├── src/
 │    ├── TaskManager.java
 │    ├── Tasks.java
 │    └── Validator.java
 ├── task.txt (data file)
 ├── .gitignore
 └── README.md

How to Run

Clone repository
Open project in VSCode / IntelliJ / terminal
Compile:
javac src/*.java


Run:
java src.TaskManager

Demo

![Task Manager Demo](demo.gif)

Future Improvements

Switch from text file to database (SQLite)
GUI version using JavaFX or Swing
Checkbox UI for tasks
Add due dates & priority levels

Author

Alessio Puppi
Java Developer | Software Enthusiast
🇺🇸 Based in USA

⭐ If you like this project, consider giving it a star!