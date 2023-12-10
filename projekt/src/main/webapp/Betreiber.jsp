<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <title>Betreiber</title>
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


<h2>Betreiber</h2>

<button onclick="biggerFontSize()">Größere Schriftgröße</button> <br> <br>

<h1><%= "Überblick der wichtigen Informationen "%><br><br><br></h1>

<form method="post">
    <label for="mitarbeiter login">Mitarbeiter-ID eintragen:</label>
    <input id="mitarbeiter login" name="message" type="number">
    <button type="button" onclick="alert('Mitarbeiter wurde nun eingetragen! ');incrementMitarbeiter()" >Absenden</button>
</form> <br>

<h2>
    Anzahl neu angemeldeter Mitarbeiter <br>
</h2>

<button onclick = "getCountMitarbeiter()">Neue Mitarbeiteranzahl aktualisiert</button> <br><br><br><br>

<h2>
    Überblick der Statistiken:
</h2>

<button onclick="">Daten abfragen</button> <br><br><br><br><br><br>


<a href="index.jsp">Zurück zum Parkhaus <br> </a> <br><br>

<br></be><a onclick="window.print()">Seite drucken</a>

<script>

    countMitarbeiter = 0;

    function getCountMitarbeiter() {
        window.alert("Es wurden nun " + countMitarbeiter + " zusätzliche Mitarbeiter erfolgreich für den Kundenservice eingeteilt! "); // window.alert instead of document.write()
    }

    function biggerFontSize() {
        document.body.style.fontSize = "35px";
    }

    function incrementMitarbeiter() {
        globalThis.countMitarbeiter = countMitarbeiter +1;
        // countMitarbeiter = countMitarbeiter+1;
    }

</script>

</body>
</html>