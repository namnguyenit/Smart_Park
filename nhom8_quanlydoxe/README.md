
# Quản lý Bãi Đỗ Xe - Nhóm 8

## Thành viên
- **Nguyễn Thành Nhân**: 23010011  
    →[nhan23ejwaf](https://github.com/nhan23ejwaf)
- **Cao Đức Trung**: 23010018  
    →[namnguyenit](https://github.com/namnguyenit)


## Mục Lục
### 1. Yêu cầu cài đặt trước cho Windows
1. [Cài đặt JRE](#cài-đặt-jre)

### 2. [Chạy dự án](#chạy-dự-án)
1. [Clone dự án](#1-clone-dự-án)
2. [Mở thư mục vừa clone dự án](#2mở-thư-mục-vừa-clone-dự-án)
3. [Chạy chương trình](#3chạy-dự-án-lưu-ý-phải-có-jre-từ-22-trở-lên)

→ Note:[Nếu bạn muốn chạy mã nguồn chương trình](#chạy-mã-nguồn-chương-trình)


### 3. Mô tả sơ lược về phần mềm
1. [Mô tả phần mềm](#mô-tả-phần-mềm)
2. [Các chức năng chính](#các-chức-năng-chính)
3. [Tài khoản đăng nhập admin](#tài-khoản-đăng-nhập-cho-admin)
4. [Yếu cầu hệ thống](#yêu-cầu-hệ-thống)
5. [Yêu cầu cài đặt](#các-yêu-cầu-cài-đặt)

### 4.Link github dự án
- [Link git](#link-github-dự-án)
---

## [Cài đặt JRE](https://www.oracle.com/java/technologies/downloads/#java23)
- Yêu cầu cài đặt JRE hoặc JDK từ bản 22 trở lên để chạy được chương trình của chúng tôi.

## Chạy dự án 
### 1. Clone dự án
```bash
git clone https://github.com/namnguyenit/Smart_Park
```
### 2.Mở thư mục vừa clone dự án
#### Cách 1:
- Tìm đến thư mục bạn vừa clone git về và mở folder Smart_Park.
#### Cách 2:
```bash
cd <Đường dẫn>\Smart_Park
```
### 3.Chạy dự án (lưu ý phải có JRE từ 22 trở lên)
#### Cách 1:
- Tìm đến folder nhom8_quanlydoxe > target.
- Tìm file :

```pwsh
    quanlybaidoxe-1.0-SNAPSHOT.jar
    # nhấn đúp chuột vào file để chạy.
```
#### Cách 2:
- bước 1
```bash
cd nhom8_quanlydoxe\target
```
- bước 2
```bash
java -jar quanlybaidoxe-1.0-SNAPSHOT.jar
```


---





## Mô tả phần mềm
Phần mềm Quản lý Bãi Đỗ Xe được xây dựng nhằm hỗ trợ quản lý các hoạt động như:
- Nhập bãi cho xe của khách.
- Quản lý xe đang gửi.
- Thanh toán khi xe rời bãi.
- Tìm kiếm thông tin xe.
- Thống kê thông tin xe và doanh thu.

## Các chức năng chính
- **Đăng nhập**: Cho phép quản lý hoặc người dùng đăng nhập vào hệ thống.
- **Tìm kiếm bãi còn trống**: Tự động tìm kiếm hoặc lựa chọn bãi xe theo yêu cầu người dùng.
- **Vào bãi**: Thêm thông tin xe của khách vào hệ thống khi xe vào bãi.
- **Xe rời bãi**: Xử lý khi khách muốn lấy xe, tính toán chi phí gửi xe dựa trên thời gian lưu trú.
- **Tạo bãi**: Tạo thông tin cho bãi xe.
- **Tìm kiếm xe**: Tìm kiếm nhanh thông tin xe đã vào bãi.
- **Thống kê**: Xem thống kê chi tiết về xe gửi trong bãi và doanh thu.

## Tài khoản đăng nhập cho admin
- **Username**: `admin`
- **Password**: `admin`

### Yêu cầu hệ thống
- **Java JDK**: Phiên bản 22 hoặc cao hơn.
- **Maven**: Nếu chạy từ mã nguồn.


## Các yêu cầu cài đặt
1. **Java Runtime Environment (JRE)**: Người dùng cần có JRE để chạy file JAR (ví dụ: Java JRE 22 hoặc cao hơn).
2. **Maven**: Nếu người dùng muốn chạy chương trình từ mã nguồn, Maven sẽ quản lý các phụ thuộc và quá trình biên dịch.

## Chạy mã nguồn chương trình
## Các yêu cầu cài đặt

1. **Java Runtime Environment (JRE)**: Người dùng cần có JRE để chạy file JAR (ví dụ: Java JRE 22 hoặc cao hơn).
2. **Maven**: Nếu người dùng muốn chạy chương trình từ mã nguồn, Maven sẽ quản lý các phụ thuộc và quá trình biên dịch.

## Chạy mã nguồn chương trình

### Bước 1: Tải và Cài đặt Maven

#### Tải Maven
- Truy cập trang web chính thức của Apache Maven: [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi).
- Tải tệp nén ZIP (hoặc TAR) của Maven.

#### Giải nén
- Giải nén tệp tải về vào một thư mục trên máy tính của bạn, ví dụ: `C:\Program Files\Apache\maven`.

#### Cấu hình biến môi trường
- **Thêm đường dẫn Maven vào PATH**:
  1. Mở Control Panel > System and Security > System > Advanced system settings.
  2. Nhấp vào nút **Environment Variables**.
  3. Tìm biến **Path** trong phần **System variables** và nhấp vào **Edit**.
  4. Thêm đường dẫn đến thư mục `bin` của Maven vào biến Path, ví dụ: `C:\Program Files\Apache\maven\apache-maven-x.x.x\bin`.

- **Tạo biến môi trường mới**:
  1. Nhấp vào **New** trong phần **System variables** và tạo biến `MAVEN_HOME` với giá trị là đường dẫn đến thư mục Maven (ví dụ: `C:\Program Files\Apache\maven\apache-maven-x.x.x`).

### Bước 2: Kiểm tra Cài đặt
Mở Command Prompt và gõ lệnh sau để kiểm tra xem Maven đã được cài đặt thành công chưa:

```pwsh
mvn -version
# Nếu bạn thấy thông tin phiên bản Maven, bạn đã cài đặt thành công.
```
### Bước 3: Chạy Dự Án
Mở cmd và điều hướng đến thư mục chứa dự án Maven của bạn.
Chạy lệnh sau để biên dịch và chạy dự án:

Chạy lệnh sau bằng cmd:
```bash
mvn clean package
```
Lệnh này sẽ biên dịch mã nguồn và tạo file JAR trong thư mục target.

Chạy file JAR bằng lệnh cmd:
```bash
java -jar target/quanlybaidoxe-1.0-SNAPSHOT.jar
```
## Link GitHub dự án
[nhom8_quanlybaidoxe](https://github.com/namnguyenit/Smart_Park)
