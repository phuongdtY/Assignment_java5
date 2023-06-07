<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/nsx/view-all">Nsx</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/dong-san-pham/view-all">Dòng sản phẩm</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/san-pham/view-all">Sản phẩm</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/mau-sac/view-all">Màu sắc</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/chi-tiet-san-pham/view-all">Chi tiết sản phẩm</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/chuc-vu/view-all">Chức vụ</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/cua-hang/view-all">Cửa hàng</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/nhan-vien/view-all">Nhân viên</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/khach-hang/view-all">Khách hàng</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <section class="text-center mb-5">
            <h1>Nhân viên</h1>
        </section>
        <section>
            <form:form action="/nhan-vien/update/${nv.id}" method="post" modelAttribute="nv" cssClass="px-5">

                <div class="row">
                    <div class="mb-3 col-3">
                        <label class="form-label">Mã nhân viên</label>
                        <form:input path="ma" cssClass="form-control"/>
                        <form:errors path="ma" cssStyle="color: red"/>
                        <label class="form-label" style="color: red">${errorMa}</label>
                    </div>

                    <div class="mb-3 col-3">
                        <span class="form-label">Họ</span>
                        <form:input path="ho" cssClass="form-control"/>
                        <form:errors path="ho" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-3">
                        <span class="form-label">Tên đệm</span>
                        <form:input path="tenDem" cssClass="form-control"/>
                        <form:errors path="tenDem" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-3">
                        <label class="form-label">Tên</label>
                        <form:input path="ten" cssClass="form-control"/>
                        <form:errors path="ten" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-3">
                        <label class="form-label">Số điện thoại</label>
                        <form:input path="soDienThoai" cssClass="form-control"/>
                        <form:errors path="soDienThoai" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-3">
                        <span class="form-label">Ngày sinh</span>
                        <form:input path="ngaySinh" type="date" cssClass="form-control"/>
                        <form:errors path="ngaySinh" cssStyle="color:red;"/>
                    </div>

                    <div class="mb-3 col-3">
                        <span class="form-label">Chức vụ</span>
                        <form:select path="chucVu" cssClass="form-select">
                            <c:forEach items="${listChucVu}" var="cv">
                                <form:option value="${cv.id}"
                                             selected="${cv.id == nv.chucVu.id ? 'true':''}">${cv.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="mb-3 col-3">
                        <span class="form-label">Cửa hàng</span>
                        <form:select path="cuaHang" cssClass="form-select">
                            <c:forEach items="${listCuaHang}" var="ch">
                                <form:option value="${ch.id}"
                                             selected="${ch.id == nv.cuaHang.id ? 'true':''}">${ch.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-6">
                        <label class="form-label">Địa chỉ</label>
                        <form:input path="diaChi" cssClass="form-control"/>
                        <form:errors path="diaChi" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-6">
                        <label class="form-label">Mật khẩu</label>
                        <form:input path="matKhau" cssClass="form-control"/>
                        <form:errors path="matKhau" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-6">
                        <label class="form-label">Giới tính</label><br/>
                        <form:radiobutton path="gioiTinh" value="Nam" checked="true" cssClass="form-check-inline"/>Nam
                        <form:radiobutton path="gioiTinh" value="Nữ" cssClass="form-check-inline"/>Nữ
                    </div>

                    <div class="mb-3 col-6">
                        <label class="form-label">Trạng thái</label><br/>
                        <form:radiobutton path="trangThai" value="0" checked="true" cssClass="form-check-inline"/>Hoạt
                        động
                        <form:radiobutton path="trangThai" value="1" cssClass="form-check-inline"/>Ngừng hoạt động
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Update</button>

            </form:form>
        </section>
    </div>
</main>
<footer class="bg-success text-white text-center text-lg-start">
    <!-- Grid container -->
    <div class="container p-4">
        <!--Grid row-->
        <div class="row">
            <!--Grid column-->
            <div class="col-12">
                <h5 class="text-uppercase">Thông tin liên hệ</h5>
                <p>
                    <span class="form-label"><b>Địa chỉ:</b> phố Trịnh Văn Bô, phường Phương Canh, quận Nam Từ Liêm, TP Hà Nội</span><br/>
                    <span class="form-label"><b>Email:</b> phuongdtph23038@gmail.com</span><br/>
                    <span class="form-label"><b>Số điện thoại:</b> 0971852413</span><br/>
                </p>
            </div>
        </div>
        <!--Grid row-->
    </div>
    <!-- Grid container -->

    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        Powered by Đặng Thanh Phương
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>