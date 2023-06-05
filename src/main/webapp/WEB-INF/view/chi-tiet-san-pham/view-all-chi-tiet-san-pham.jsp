<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chi tiết sản Phẩm</title>
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
                </ul>
            </div>
        </div>
    </nav>
</header>
<main>
    <div class="container">
        <section class="text-center mb-5">
            <h1>Chi tiết Sản Phẩm</h1>
        </section>
        <section>
            <form:form action="/chi-tiet-san-pham/add" method="post" modelAttribute="ctsp" cssClass="px-5">
                <div class="row">
                    <div class="mb-3 col-3">
                        <label class="form-label">sản phẩm</label>
                        <form:select path="sanPham" cssClass="form-select">
                            <c:forEach items="${listSanPham}" var="sp">
                                <form:option value="${sp.id}" selected="${sp.id == ctsp.sanPham.id ? 'true':''}">${sp.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="mb-3 col-3">
                        <label class="form-label">Nhà sản xuất</label>
                        <form:select path="nsx" cssClass="form-select">
                            <c:forEach items="${listNsx}" var="nsx">
                                <form:option value="${nsx.id}" selected="${nsx.id == ctsp.nsx.id ? 'true':''}">${nsx.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="mb-3 col-3">
                        <label class="form-label">Màu sắc</label>
                        <form:select path="mauSac" cssClass="form-select">
                            <c:forEach items="${listMauSac}" var="ms">
                                <form:option value="${ms.id}" selected="${ms.id == ctsp.mauSac.id ? 'true':''}">${ms.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="mb-3 col-3">
                        <label class="form-label">Dòng sản phẩm</label>
                        <form:select path="dongSanPham" cssClass="form-select">
                            <c:forEach items="${listDongSanPham}" var="dsp">
                                <form:option value="${dsp.id}" selected="${dsp.id == ctsp.dongSanPham.id ? 'true':''}">${dsp.ten}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <span class="form-label" style="color: red">${errorTonTai}</span>
                <div class="row">
                    <div class="mb-3 col-6">
                        <span class="form-label">Năm bảo hành</span>
                        <form:input path="namBaoHanh" cssClass="form-control"/>
                        <form:errors path="namBaoHanh" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-6">
                        <span class="form-label">Số lượng tồn</span>
                        <form:input path="soLuongTon" cssClass="form-control"/>
                        <form:errors path="soLuongTon" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="row">
                    <div class="mb-3 col-6">
                        <span class="form-label">Giá nhập</span>
                        <form:input path="giaNhap" cssClass="form-control"/>
                        <form:errors path="giaNhap" cssStyle="color: red"/>
                    </div>

                    <div class="mb-3 col-6">
                        <span class="form-label">Giá bán</span>
                        <form:input path="giaBan" cssClass="form-control"/>
                        <form:errors path="giaBan" cssStyle="color: red"/>
                    </div>
                </div>

                <div class="mb-3">
                    <span class="form-label">Mô tả</span>
                    <form:textarea path="moTa" cssClass="form-control"/>
                    <form:errors path="moTa" cssStyle="color: red"/>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>

            </form:form>
        </section>
        <section>
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Sản phẩm</th>
                    <th>Nsx</th>
                    <th>Màu sắc</th>
                    <th>Dòng sản phẩm</th>
                    <th>Năm bảo hành</th>
                    <th>Số lượng tồn</th>
                    <th>Giá nhập</th>
                    <th>Giá bán</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listChiTietSanPham.content}" var="ctsp" varStatus="stt">
                    <tr>
                        <td>${stt.index + 1}</td>
                        <td>${ctsp.sanPham.ten}</td>
                        <td>${ctsp.nsx.ten}</td>
                        <td>${ctsp.mauSac.ten}</td>
                        <td>${ctsp.dongSanPham.ten}</td>
                        <td>${ctsp.namBaoHanh}</td>
                        <td>${ctsp.soLuongTon}</td>
                        <td>${ctsp.giaNhap}</td>
                        <td>${ctsp.giaBan}</td>
                        <td>
                            <a href="/chi-tiet-san-pham/detail/${ctsp.id}" class="btn btn-warning">Detail</a>
                            <a href="/chi-tiet-san-pham/view-update/${ctsp.id}" class="btn btn-success">Update</a>
                            <a href="/chi-tiet-san-pham/remove/${ctsp.id}" class="btn btn-danger">Remove</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item ${pageNo <= 0 ? 'disabled':''}">
                        <a class="page-link" href="/chi-tiet-san-pham/view-all?page=${ pageNo - 1}">Previous</a>
                    </li>

                    <c:forEach begin="0" end="${listChiTietSanPham.totalPages - 1}" varStatus="loop">
                        <li class="page-item"><a class="page-link"
                                                 href="/chi-tiet-san-pham/view-all?page=${loop.begin + loop.count - 1}">
                                ${loop.begin + loop.count}
                        </a></li>
                    </c:forEach>

                    <li class="page-item page-item ${pageNo >= listChiTietSanPham.totalPages - 1 ? 'disabled':''}">
                        <a class="page-link" href="/chi-tiet-san-pham/view-all?page=${ pageNo + 1}">Next</a>
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