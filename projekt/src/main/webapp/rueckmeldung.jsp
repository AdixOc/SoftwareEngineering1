<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title>Rueckmeldung</title>
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
    }
</style>

<h2>Rückmeldung zum Parkhaus</h2>
<button onclick="biggerFontSize()">Größere Schriftgröße</button>
<h1><%= "Hinterlassen Sie eine Rückmeldung Ihrer Erfahrungen!" %></h1>
<form method="post" action="index.jsp">
    <label for="message">Nachricht:</label>
    <input id="message" name="message" type="text">
    <button type="submit" onclick="alert('Danke für Ihre Rückmeldung. Sie werden nun wieder zur Hauptseite zurückgeführt')">Submit</button>
</form>
<p>Vielen Dank für Ihre Rückmeldung. Sie können uns auch bei Fragen gerne auf direktem Weg kontaktieren.</p>
<a href="index.jsp">Zurück zum Parkhaus</a> <br> <br>
<a onclick="window.print()">Seite drucken</a>

<script>
    function biggerFontSize() {
        document.body.style.fontSize = "35px";
    }
</script>
</body>
</html>