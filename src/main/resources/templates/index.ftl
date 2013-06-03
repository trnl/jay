<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Package Index</title>
    <link rel="stylesheet" href="/code/jay/src/main/resources/css/pure-min.css"/>
    <link rel="stylesheet" href="/code/jay/src/main/resources/css/app.css"/>
</head>

<body>
<div class="pure-g" id="layout">
    <div class="pure-u" id="menu">
        <div class="pure-menu pure-menu-open">
            <a class="pure-menu-heading" href="#">Driver</a>
            <ul>
                <li><a href="#">Flickr</a></li>
                <li><a href="#">Messenger</a></li>
                <li><a href="#">Sports</a></li>
                <li><a href="#">Finance</a></li>
                <li><a href="#">Games</a></li>
                <li><a href="#">News</a></li>
                <li><a href="#">OMG!</a></li>
            </ul>
        </div>

    </div>
    <div class="pure-u" id="main">
        <div class="header pure-u-1">
            <h1 class="pure-u-1">Tables</h1>
        </div>
        <div class="content">
            <table class="pure-table">
                <thead>
                <tr>
                    <th>Packages</th>
                </tr>
                </thead>
                <tbody>
                <#list packages as package>
                <tr>
                    <td>${package.name}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="legal">
            <p class="l-box">Minsk. 2013</p>
        </div>
    </div>
</div>

</body>

</html>