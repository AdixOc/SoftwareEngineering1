<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <meta name="author" content="Team22 (C) 2021">
    <meta name="description" content="Software Engineering 1 (SE1)">
    <meta name="license" content="The MIT License (MIT)">
    <meta name="theme-color" content="#239BD1"/>
    <meta property="og:title" content="Software Engineering 1 Project(SE1)">
    <meta property="og:description" content="Bachelor Course Software Engineering 1 (SE1), Hochschule Bonn-Rhein-Sieg.">
    <link rel="shortcut icon" href="https://kaul.inf.h-brs.de/favicon.ico"/>
    <title>Tomcat Parkhaus</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js"></script>
    <script src="https://kaul.inf.h-brs.de/ccmjs/mkaul-components/parkhaus/versions/ccm.parkhaus-11.0.0.js"></script>
    <style>
        * {
            font-family: Helvetica, Arial, sans-serif;
        }

        .grey-background {
            background-color: whitesmoke;
        }

        .center {
            text-align: center;
        }

        .box {
            border: thin solid black;
            margin: 0.5rem 0;
            padding: 1rem;
        }

        .lightblue {
            background-color: #d0ebf6;
        }

        .lightyellow {
            background-color: lightgoldenrodyellow;
        }

        .lightgreen {
            background-color: #ccfdcc;
        }

        h1 {
            color: blanchedalmond;
            font-size: 25px;
        }

        div {
            background-color: rgb(101, 138, 136);
        }
    </style>
</head>


</div class="box">
<h1 id="ueberschrift_1" style="color: #2a2222">Willkommen im Parkhaus! </h1>
<style>
    h1 {
        color: blanchedalmond;
        font-size: 30px;
    }
</style>
</div>

<body>
<button onclick="darkModeFunction()">DarkMode aktivieren</button>
<button onclick="biggerFontSize()">Größere Schriftgröße</button>
</body>


<div class="box center name">
    <div style="flex-direction: row; display: flex; background-color: rgba(0,0,0,0)">
        <canvas id="usageChartLevel1" width="400" height="400"></canvas>
        <canvas id="usageChartLevel2" width="400" height="400"></canvas>
    </div>
    <style>
        p {
            color: rgba(89, 93, 138, 0.58)
        }
    </style>
    <h1>Parkhaus Team22</h1>
    <p>Tomcat Version : <%= application.getServerInfo() %>
    </p>
    <em><a href="rueckmeldung.jsp">Rückmeldung</a></em>
    <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong>
    <em><a href="Support.jsp">Support</a></em>
    <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong>
    <em><a href="Betreiber.jsp">Betreiber</a></em>
</div>

<script>
    const ctx1 = document.getElementById('usageChartLevel1');
    const ctx2 = document.getElementById('usageChartLevel2');
    const usageChartLevel1 = new Chart(ctx1, {
        type: 'pie',
        data: {
            labels: ['Free', 'Used'],
            datasets: [
                {
                    label: 'Ebene 1',
                    data: [1,1],
                    backgroundColor: ['#2ecc71', '#bd1e1e']
                }
            ]
        },
        options: {
            responsive: false,
            plugins: {
                legend: {
                    position: 'top'
                },
                title: {
                    display: true,
                    text: 'Frauenparkplatz auslastung',
                    color: '#161616',
                    fontSize: '20pt'
                }
            }
        },
    });
    const usageChartLevel2 = new Chart(ctx2, {
        type: 'pie',
        data: {
            labels: ['Free', 'Used'],
            datasets: [
                {
                    label: 'Ebene 2',
                    data: [1,1],
                    backgroundColor: ['#2ecc71', '#bd1e1e']
                }
            ]
        },
        options: {
            responsive: false,
            plugins: {
                legend: {
                    position: 'top'
                },
                title: {
                    display: true,
                    text: 'Etage 2 auslastung',
                    color: '#161616',
                    fontSize: '20pt'
                }
            }
        },
    });
    function updateChart() {
        axios.get('/level1-servlet?cmd=chart').then(function (response) {
            let arr = response.data.chartData[0];
            if (arr == null) {
                arr = [1,0];
            }
            usageChartLevel1.data.datasets[0].data = arr;
            usageChartLevel1.update();
        })
        axios.get('/level2-servlet?cmd=chart').then(function (response) {
            let arr = response.data.chartData[0];
            if (arr == null) {
                arr = [1,0];
            }
            usageChartLevel2.data.datasets[0].data = arr;
            usageChartLevel2.update();
        })
    }
    //update chart intially
    updateChart();
    //timer that calls updateChart every 2 seconds
    setInterval(updateChart, 2000);
</script>

<div class="box">
    <h2><a href="kasse.jsp">Kasse</a></h2>
    <p style="color:lavenderblush;font-size: 30px">Wählen Sie unten die gewünschte Ebene aus! </p>
</div>


<div class="box">
    <h1>Parkhaus Frauenparkplätze</h1>
    <ccm-parkhaus-11-0-0 server_url="./level1-servlet"
                         debug="true"
                         name="Etage1"
                         license_max="15"
                         extra_buttons='["sum","min", "avg"]'
                         client_categories='["Frau"]'
                         space_color='{"1":"pink"}'
                         vehicle_types='["PKW","SUV"]'
                         price_factor='{"SUV":2,"Family":0.5}'
                         max="11"
                         json_format="true">
    </ccm-parkhaus-11-0-0>
    <script>
        function darkModeFunction(){
            document.body.style.backgroundColor = 'darkgrey';
            //all elements with class "box" will be black
            for (let i = 0; i < document.getElementsByClassName("box").length; i++) {
                document.getElementsByClassName("box")[i].style.backgroundColor = "#000000";
            }
        }

        function biggerFontSize() {
            for (let i = 0; i < document.getElementsByClassName("box").length; i++) {
                document.getElementsByClassName("box")[i].style.fontSize = "35px";
            }

            for (let i = 0; i < document.getElementsByClassName("box").length; i++) {
                document.getElementsByClassName("box")[i].querySelectorAll("h1") = "35px";
            }

        }
    </script>
</div>
<div class="box Etage2">
    <h1>Parkhaus Etage 2</h1>
    <ccm-parkhaus-11-0-0 server_url="./level2-servlet"
                         name="Etage2"
                         license_min="16"
                         extra_buttons='["sum","min", "avg", "anzahlBusiness"]'
                         license_max="30"
                         client_categories='["any","Business"]'
                         space_color='{"1":"yellow","6":"black"}'
                         vehicle_types='["PKW","SUV"]'
                         price_factor='{"SUV":2,"Business":1}'
                         debug="true"
                         hide_table="false"
                         SALT="187"
                         json_format="true">
    </ccm-parkhaus-11-0-0>
    <style>
        p {
            color: rgba(89, 93, 138, 0.58)
        }
    </style>
</div>
<br> <br>
<a onclick="window.print()">Seite drucken</a>

</body>
</html>