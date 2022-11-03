

CREATE TABLE Bills(mid varchar(20), lastPaidDate date, dueAmount int, lateCharge int, dueDate date, pid varchar(20));

INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) VALUES ('M101', '2022-06-01', 10000, 800, '2021-02-01',  'P1001');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M102', '2022-12-10', 50500, 6500, '2020-12-10', 'P1003');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M103', '2022-07-20', 12000, 0, '2022-07-30', 'P1004');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M104', '2022-01-01', 8000, 0, '2021-08-10', 'P1002');
INSERT INTO Bills(mid, lastPaidDate, dueAmount, lateCharge, dueDate, pid) values('M105', '2022-01-05', 25000, 4000, '2021-07-05', 'P1003');