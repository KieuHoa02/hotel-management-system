use QLKS;
-- Bảng Khách hàng
CREATE TABLE KHACH (
    KID INT PRIMARY KEY,
	TEN varchar(50),
    Email VARCHAR(100),
    Phone VARCHAR(20)
);

-- Bảng Phòng
CREATE TABLE PHONG (
    PID INT PRIMARY KEY,
    SOPHONG INT,
    LOAIPHONG VARCHAR(50),
    GIA DECIMAL(10, 2)
);

-- Bảng Đặt phòng
CREATE TABLE Bookings (
    BookingID INT PRIMARY KEY,
    KID INT,
    PID INT,
    CheckInDate DATE,
    FOREIGN KEY (KID) REFERENCES KHACH(KID),
    FOREIGN KEY (PID) REFERENCES PHONG(PID)
);

-- Bảng Dịch vụ
CREATE TABLE DICHVU (
    DID INT PRIMARY KEY,
    TENDV VARCHAR(50),
    GIATHEM DECIMAL(10, 2)
);

SELECT * FROM DICHVU;



select * from KHACH;
-- Thêm dữ liệu vào bảng KHACH
INSERT INTO KHACH (KID, TEN, Email, Phone) VALUES (1, 'Nguyen Van Minh', 'MinhHELLO@email.com', '1234567890');
 INSERT INTO KHACH (KID, TEN, Email, Phone) VALUES   (2, 'Tran Thi Binh', 'BinhHAYCUOI@email.com', '0987654321');
 INSERT INTO KHACH (KID, TEN, Email, Phone) VALUES   (3, 'Le Van Cang', 'BINHYEN@email.com', '1122334455');
    -- Thêm dữ liệu khác tương tự cho các dòng còn lại.

-- Thêm dữ liệu vào bảng PHONG
INSERT INTO PHONG (PID, SOPHONG, LOAIPHONG, GIA)
VALUES
    (1, 101, 'TAM TRUNG', 100),
    (2, 201, 'VUA VUA', 150),
    (3, 301, 'SANG CHANH', 200);
    -- Thêm dữ liệu khác tương tự cho các dòng còn lại.

-- Thêm dữ liệu vào bảng Bookings
INSERT INTO Bookings (BookingID, KID, PID, CheckInDate)
VALUES
    (1, 1, 1, '2023-01-01'),
    (2, 2, 2, '2023-02-15'),
    (3, 3, 3, '2023-03-30');
    -- Thêm dữ liệu khác tương tự cho các dòng còn lại.

-- Thêm dữ liệu vào bảng DICHVU
INSERT INTO DICHVU (DID, TENDV, GIATHEM)
VALUES
    (1, 'Wifi', 10),
    (2, 'COM THEM', 30),
    (3, 'GIAT DO', 20);
    -- Thêm dữ liệu khác tương tự cho các dòng còn lại.
-- Thêm 6 dòng dữ liệu vào bảng KHACH
select * from DICHVU;


select * from khach;
DROP TABLE DICHVU;
DROP TABLE PHONG;
DROP TABLE KHACH;
DROP TABLE BOOKINGS;

use qlks;

delimiter $
CREATE procedure ins_phong(
    pidd INT,
    sophongd INT,
    loaiphongd VARCHAR(50),
    giad DECIMAL(10, 2) )
BEGIN
    INSERT INTO PHONG (PID, SOPHONG, LOAIPHONG, GIA) 
    VALUES (pidd, sophongd, loaiphongd, giad);
END$

delimiter $
CREATE procedure update_gia 
(pidd INT, new_gia DECIMAL(10, 2) )
BEGIN
    UPDATE PHONG SET GIA = new_gia 
    WHERE PID = pidd;
END $

DELIMITER ;



-- thu du lieu
select * from phong;
delete from phong where PID = 4;

DELIMITER //
CREATE PROCEDURE ThemKhach1(
    IN p_TEN VARCHAR(50),
    IN p_Email VARCHAR(100),
    IN p_Phone VARCHAR(20)
)
BEGIN
    INSERT INTO KHACH (TEN, Email, Phone) 
    VALUES (p_TEN, p_Email, p_Phone);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ThemKhach(
    IN p_PID INT,
    IN p_TEN VARCHAR(50),
    IN p_Email VARCHAR(100),
    IN p_Phone VARCHAR(20)
)
BEGIN
    INSERT INTO KHACH (KID, TEN, Email, Phone) 
    VALUES (p_PID, p_TEN, p_Email, p_Phone);
END //
drop procedure Themkhach;
DELIMITER ;
delete from Khach where KID = 4;

DELIMITER //
CREATE PROCEDURE booking(
    K_PID INT,
    p_TEN VARCHAR(50),
    p_Email VARCHAR(100),
    p_Phone VARCHAR(20),
    pidd INT,
    sophongd INT,
    loaiphongd VARCHAR(50),
    giad DECIMAL(10, 2) ,
    bookIDE int)

BEGIN
    INSERT INTO KHACH (KID, TEN, Email, Phone) VALUES (p_PID, p_TEN, p_Email, p_Phone);
    INSERT INTO PHONG (PID, SOPHONG, LOAIPHONG, GIA) VALUES (pidd, sophongd, loaiphongd, giad);
    INSERT INTO BOOKINGS ( BOOKID, KID, PID, CHECKINDATE) values (BOOKIDE, K_ID, pidd);
END //

-----------------------

DELIMITER //
CREATE PROCEDURE Booking(
    IN p_PID INT,
    IN p_TEN VARCHAR(50),
    IN p_Email VARCHAR(100),
    IN p_Phone VARCHAR(20),
    ppID INT,
    IN bookIDE INT
)
BEGIN
    INSERT INTO KHACH (KID, TEN, Email, Phone) 
    VALUES (p_PID, p_TEN, p_Email, p_Phone);
    INSERT INTO BOOKINGS (BookingID, KID, PID, CHECKINDATE) 
    VALUES (bookIDE, p_PID, ppID, NOW());
END //
DELIMITER ;
drop procedure booking;
DELIMITER //
CREATE PROCEDURE XoaBooking(
    IN p_BookingID INT
)
BEGIN
    DELETE FROM Bookings WHERE BookingID = p_BookingID;
END //
DELIMITER ;
 select * from bookings;
  select * from Khach;
DELETE FROM KHACH WHERE KID=4;
DELETE FROM Bookings WHERE BookingID = 4;




