# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
- Name: Naila Izzati Belladiva
- Student ID: 5026251180
- Class: A

## Project Description
Project ini adalah aplikasi permainan Tic-Tac-Toe sederhana melawan komputer, dibangun menggunakan Java Swing untuk tampilan antarmuka (GUI), dengan fitur login pemain dan penyimpanan statistik permainan ke dalam database PostgreSQL menggunakan JDBC.

## Features
1. Login pemain menggunakan data dari database (username & password).
2. Permainan Tic-Tac-Toe melawan komputer menggunakan GUI Swing (JButton 3x3).
3. Deteksi otomatis kondisi menang, kalah, dan seri.
4. Pencatatan statistik (wins, losses, draws, score) yang diperbarui ke database
  setiap kali permainan selesai.
5. Tampilan statistik pribadi pemain yang sedang login.
6. Tampilan Top 5 pemain dengan skor tertinggi menggunakan `JTable`, diambil
  langsung dari database (tidak di-hardcode).

## Database
Database used: PostgreSQL

## How To Run
1. Download repository
2. Buat database PostgreSQL
3. Jalankan file 'schema.sql' untuk membuat tabel
4. Sesuaikan konfigurasi database pada 'DatabaseManager.java' (host, port, database, username, dan password).
5. Buka project menggunakan NetBeans/IDE Java/VSCode
6. Jalankan kelas Main.java
7. Login menggunakan akun yang tersedia (bisa lihat dari database)
8. Mulai bermain melalui menu utama

## Class Explanation
1. Main: Entry point aplikasi yang menjalankan program
2. DatabaseManager: Mengelola koneksi dan operasi database PostgreSQL
3. Player: Menyimpan data dan informasi pemain yg login
4. PlayerService: Mengelola proses yang berkaitan dengan pemain, seperti login, penyimpanan, atau pengambilan data
5. GameLogic: Isinya aturan dan logika utama permainan
6. GameBoard: Mengelola papan permainan serta interaksi selama game berlangsung
7. LoginFrame:  Menampilkan GUI login untuk pengguna
8. MainMenuFrame: Menampilkan halaman menu aplikasi setelah pengguna berhasil login, ada button start, statistik, top skor dan exit
9. GameFrame: Menampilkan halaman utama dimana permainan dijalankan
10. StatisticsFrame: Menampilkan statistik permainan atau riwayat pemain, isinya banyak menang, kalah, seri, dan total skor
11. TopScorersFrame: Menampilkan data pemain dengan skor tertinggi (5 teratas)

## Screenshots

## Video Link
https://youtu.be/4uk2e6i8Ddk 
