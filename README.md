# Họ và tên: Lương Tấn Đạt
# MSSV: 21026661
# Giáo viên hướng dẫn: Võ Văn Hải

# Giới thiệu

Bài tập yêu cầu xây dựng một hệ thống quản lý tuyển dụng với các tính năng sau:

1. Tạo các entities sao cho khi thực thi, các bảng dữ liệu sẽ được tạo ra theo thiết kế đã có.
2. Viết các repository interfaces cho các entities đã tạo.
3. Viết các lớp service để xử lý logic cho các hành động trong ứng dụng.
4. Tạo các trang web cho phép công ty đăng tin tuyển dụng và yêu cầu các kỹ năng mong muốn cho công việc.
5. Gợi ý công việc cho ứng viên dựa trên các kỹ năng của họ khi họ đăng nhập.
6. Giúp các công ty tìm ứng viên có kỹ năng phù hợp và gửi email mời.
7. Đề xuất các kỹ năng mà ứng viên chưa có để học thêm.
8. Gửi mail cho ứng viên

# Lưu ý 
chạy file `resoures/lab-week-05.sql`
# Chuc Nang

## 1. Hệ thống đăng nhập phân quyền với Spring Security

- COMPANY: Vai trò này dành cho các công ty, cho phép họ đăng tuyển và quản lý các vị trí công việc, được gợi ý ứng viên
  dựa trên yêu cầu kĩ năng công việc.
- CANDIDATE: Vai trò này dành cho ứng viên, cho phép họ xem các công việc gợi ý dựa trên kĩ năng của ứng viên.

### Đăng nhập với vai trò COMPANY
- username : diana.lee
- password : 123456

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/login-company.png)

### Xem so luong cong viec 

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/dashboard.png)

### Xem danh sach cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/available.png)

### Xem chi tiet cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/more-details-job.png)

### Quan ly cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/manage-job.png)

### Them cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/addJob.png)

### Sua cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/update-job.png)

### Dang Nhap voi vai tro CANDIDATE
- username : john.doe
- password : 123456

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/login-candidate.png)

### Xem danh sach cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/job-available.png)

### Xem chi tiet cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/more-details-job.png)

### Tim kiem cong viec

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/search-job.png)

### Cap nhat thong tin ca nhan

![image](https://github.com/LTDat03/WWW_Lab05/blob/main/src/main/resources/static/info-candidate.png)
