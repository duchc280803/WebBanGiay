<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/15/2023
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="total" value="0"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="org.apache.struts.util.LocalStrings"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/admin/dashboard.css">
    <style>
        header.navbar.navbar-dark.sticky-top.bg-dark.flex-md-nowrap.p-0.shadow {
            background-color: #0CBEF0 !important;
        }

        ul.nav.flex-column {
            width: 100%;
            line-height: 40px;
            padding: 0px 10px;
            color: #fff;
            font-size: 13px;
            font-weight: bold;
            text-transform: uppercase;
            position: relative;
            border: 0px;
            float: left;
        }

        a.nav-link:hover {
            color: coral;
        }
    </style>
</head>
<body>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/product/hien-thi">Shoe Store</a>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="/dang-nhap/logout">Sign out</a>
        </div>
    </div>
</header>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/dashboard">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-home" aria-hidden="true">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/oder/hien-thi">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-file" aria-hidden="true">
                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                <polyline points="13 2 13 9 20 9"></polyline>
                            </svg>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/product-manager/hien-thi-product">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true">
                                <circle cx="9" cy="21" r="1"></circle>
                                <circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                            </svg>
                            Products
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Doanh Số Tháng Này</h4>
                                <h6 class="card-title" style="color: #E6970B">Tổng Đơn Hàng: ${countOderMonth} / Doanh
                                    Thu: <fmt:formatNumber value="${totalMoney}" pattern="###,###"/> đ</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Hôm Nay</h4>
                                <h6 class="card-title" style="color: #E6970B">Tổng Đơn Hàng: ${countOderDay} / Doanh
                                    Thu: <fmt:formatNumber value="${totalMoneyDay}" pattern="###,###"/> đ</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Hàng Bán Được Tháng Này</h4>
                                <h6 class="card-title" style="color: #E6970B">${countProductMonth} Sản Phẩm</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
            </div>
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-4">
                                        <input id="startDateInput" class="form-control" type="date"/>
                                    </div>
                                    <div class="col-4">
                                        <input id="endDateInput" class="form-control" type="date"/>
                                    </div>
                                    <div class="col-4">
                                    </div>
                                </div>
                                <br>
                                <canvas id="barChart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        </main>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    // Get the canvas elements
    var ctxBar = document.getElementById('barChart').getContext('2d');

    // Define the data for the charts
    var barChartData = {
        labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
        datasets: [{
            label: 'Bar Chart',
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1,
            data: [
                ${selectMonthJanuary},
                ${selectMonthFebruary},
                ${selectMonthMarch},
                ${selectMonthApril},
                ${selectMonthMay},
                ${selectMonthJune},
                ${selectMonthJuly},
                ${selectMonthAugust},
                ${selectMonthSeptember},
                ${selectMonthOctober},
                ${selectMonthNovember},
                ${selectMonthDecember}
            ]
        }]
    };

    // Create the bar chart
    var barChart = new Chart(ctxBar, {
        type: 'bar',
        data: barChartData
    });

    var startDateInput = document.getElementById('startDateInput');
    var endDateInput = document.getElementById('endDateInput');

    startDateInput.addEventListener('change', updateBarChart);
    endDateInput.addEventListener('change', updateBarChart);

    // Function to update the bar chart based on the selected dates
    function updateBarChart() {
        var startDate = new Date(startDateInput.value);
        var endDate = new Date(endDateInput.value);

        // Calculate the number of months between the start and end dates
        var numMonths = (endDate.getFullYear() - startDate.getFullYear()) * 12 + (endDate.getMonth() - startDate.getMonth()) + 1;

        // Generate an array of data for the selected months
        var newData = [];
        for (var i = 0; i < numMonths; i++) {
            if (startDate.getMonth() + i === 5) { // Check if the current month is June (index 5)
                newData.push(getDataForMonth(startDate.getMonth() + i));
            } else {
                newData.push(0); // If it's not June, set the data to 0
            }
        }

        // Update the data and labels of the bar chart
        barChart.data.labels = generateMonthLabels(startDate, numMonths);
        barChart.data.datasets[0].data = newData;

        // Update the bar chart
        barChart.update();
    }

    // Function to generate the month labels for the bar chart
    function generateMonthLabels(startDate, numMonths) {
        var labels = [];
        var currentMonth = startDate.getMonth();
        var currentYear = startDate.getFullYear();

        for (var i = 0; i < numMonths; i++) {
            labels.push(getMonthLabel(currentMonth, currentYear));
            currentMonth++;
            if (currentMonth > 11) {
                currentMonth = 0;
                currentYear++;
            }
        }

        return labels;
    }

    // Function to get the data for a specific month
    function getDataForMonth(month) {
        // Replace this with your logic to retrieve data for the specified month (June)
        // In this case, you can return the actual data you have for June
        return 100; // Example data for June
    }

    // Function to get the label for a specific month
    function getMonthLabel(month, year) {
        var monthNames = ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'];
        return monthNames[month] + ' ' + year;
    }
</script>
<script src="/js/bootstrap.js"></script>
</html>
