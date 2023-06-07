<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cửa hàng</title>
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
            <h1>Cửa hàng</h1>
        </section>
        <section>
            <form:form action="/cua-hang/add" method="post" modelAttribute="ch" cssClass="px-5">

                <div class="mb-3">
                    <label class="form-label">Mã cửa hàng</label>
                    <form:input path="ma" cssClass="form-control"/>
                    <form:errors path="ma" cssStyle="color: red"/>
                    <label class="form-label" style="color: red">${errorMa}</label>
                </div>

                <div class="mb-3">
                    <label class="form-label">Tên cửa hàng</label>
                    <form:input path="ten" cssClass="form-control"/>
                    <form:errors path="ten" cssStyle="color: red"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Đia chỉ cửa hàng</label>
                    <form:input path="diaChi" cssClass="form-control"/>
                    <form:errors path="diaChi" cssStyle="color: red"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Thành phố cửa hàng</label>
                    <form:input path="thanhPho" cssClass="form-control"/>
                    <form:errors path="thanhPho" cssStyle="color: red"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Quốc gia cửa hàng</label>
                    <form:input path="quocGia" cssClass="form-control"/>
                    <form:errors path="quocGia" cssStyle="color: red"/>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>

            </form:form>
        </section>
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Mã</th>
                    <th>tên</th>
                    <th>địa chỉ</th>
                    <th>Thành phố</th>
                    <th>quốc gia</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listCuaHang.content}" var="ch" varStatus="stt">
                    <tr>
                        <td>${stt.index + 1}</td>
                        <td>${ch.ma}</td>
                        <td>${ch.ten}</td>
                        <td>${ch.diaChi}</td>
                        <td>${ch.thanhPho}</td>
                        <td>${ch.quocGia}</td>
                        <td>
                            <a href="/cua-hang/detail/${ch.id}" class="btn btn-warning">Detail</a>
                            <a href="/cua-hang/view-update/${ch.id}" class="btn btn-success">Update</a>
                            <a href="/cua-hang/remove/${ch.id}" class="btn btn-danger">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item ${pageNo <= 0 ? 'disabled':''}">
                        <a class="page-link" href="/cua-hang/view-all?page=${ pageNo - 1}">Previous</a>
                    </li>

                    <c:forEach begin="0" end="${listCuaHang.totalPages - 1}" varStatus="loop">
                        <li class="page-item"><a class="page-link"
                                                 href="/cua-hang/view-all?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count}
                        </a></li>
                    </c:forEach>

                    <li class="page-item page-item ${pageNo >= listCuaHang.totalPages - 1 ? 'disabled':''}">
                        <a class="page-link" href="/cua-hang/view-all?page=${ pageNo + 1}">Next</a>
                    </li>
                </ul>
            </nav>
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