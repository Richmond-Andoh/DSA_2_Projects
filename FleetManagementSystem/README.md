# Vehicle Tracking & Maintenance System for Adom Logistics

## 🎓 DCIT308: Data Structures & Algorithms 2 - Semester Project
**University of Ghana**  
**Department of Computer Science**  
**Presentation Date: July 17, 2025**

---

## 👩‍💻 Project Description
This is a fully offline, console-based logistics management system built for Adom Logistics to:

- Track vehicles and their usage
- Manage driver assignments
- Simulate deliveries and routes
- Schedule vehicle maintenance
- Generate fuel usage reports
- Save and load all records from local `.txt` files

The system was built using **only fundamental data structures and algorithms** — without any external libraries or APIs.

---

## 🧱 Technologies & Tools
- Language: **Java (no frameworks)**
- Data Structures Used:
  - **HashMap** – for fast vehicle lookup
  - **Queue** – for available driver assignment
  - **LinkedList** – for delivery tracking
  - **Min-Heap** – for scheduling vehicle maintenance
  - **Manual Sorting** – insertion, merge, quick sort
- File I/O – for offline data storage

---

## 📂 Features

### 🚗 Vehicle Module
- Add, remove, search vehicles
- Stores type, registration, mileage, fuel, driver

### 👨‍✈️ Driver Assignment
- Queue of available drivers
- Tracks infractions, experience, routes

### 📦 Delivery Tracker
- Linked list of deliveries
- Allows rerouting, status updates

### 🛠️ Maintenance Scheduler
- Min-heap based service queue
- Prioritized by mileage since last service

### ⛽ Fuel Efficiency Reports
- Detects fuel outliers
- Supports filtering and sorting by fuel, mileage, driver

### 💾 File Storage
- Automatically saves and loads:
  - `vehicles.txt`
  - `drivers.txt`
  - `deliveries.txt`
  - `maintenance.txt`

---

## 📌 How to Run

1. Open terminal inside `/src/` folder.
2. Compile the Java files:
