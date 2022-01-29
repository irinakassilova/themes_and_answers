<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div id="customers">
    <div class="container">
        <form action="/login" method="post" class="form-group">
            <div>
                <#if error!false >
                    <p >Неверные имя пользователя или пароль !</p>
                </#if>
            </div>

            <label>Nick Name</label>
            <input type="text" name="username" class="form-control" value="${(user.name)!''}" autofocus>

            <label>Пароль</label>
            <input type="text" name="password" class="form-control" value="">

            <button class="btn btn-primary" type="submit">Войти</button>

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
        </form>
        <div>
            <a href="/">Back to home page</a>
        </div>
    </div>
</div>
</body>
</html>