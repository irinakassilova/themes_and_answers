<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
</head>
<body>
<div id="foods">
    <div class="foods">
        <form action="/register" name="f" method="post">
            <fieldset>
                <input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>
                <legend>Please Register</legend>
                <label for="name">Nick name</label>
                <input type="text" id="name" name="name"  />
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>
                <div class="form-actions">
                    <button type="submit" class="btn">Reg</button>
                </div>
            </fieldset>

            <#if errors??>
                <p>Incorrect register data</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage}</p>
                </#list>
            </#if>
        </form>
        <div>
            <a href="/">Back to home page</a>
        </div>
    </div>
</div>
</body>
</html>