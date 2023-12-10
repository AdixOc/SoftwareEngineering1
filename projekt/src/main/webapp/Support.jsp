<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title>Support</title>
</head>
<body>

<style>

    h1 {
        color: darkslateblue;
        font-size: 35px;
    }

    b {
        color: black;
    }

    body {
        background-color: darkseagreen;
        text-decoration-color: darkgrey;
    }
</style>

<h2>Willkommen auf der Support Seite!</h2>

<button onclick="biggerFontSize()">Größere Schriftgröße</button>

<h1><%= "Sie haben Fragen oder anderweitige Schwierigkeiten? Kein Problem! "%><br></h1>

<strong>
    Sie können während der Öffnungszeiten gerne die folgende Nummer anrufen und wir verbinden
    Sie mit einem Mitarbeiter! <br>
</strong>

<h1>Öffnungszeiten<br></h1>
<strong>Montag-Samstag: <em>0:00 - 24:00</em><br>
Sonntag: <em>geschlossen</em></strong><br><br>

<strong>Telefon/SMS </strong><em>0A52 5989T1HI8<br> </em><br>
<a href="index.jsp">Zurück zum Parkhaus <br> </a> <br> <br>
<a onclick="window.print()">Seite drucken</a>


<script>

    function biggerFontSize() {
        document.body.style.fontSize = "35px";
    }
</script>

</body>
</html>