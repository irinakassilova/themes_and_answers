<#import "partials/main.ftlh" as main />

<h1>Создание новой темы</h1>
<form action="/themes/add" method="post">
    <div class="form-group">
        <label for="name">Название</label>
        <input class="form-control" id="title" type="text" name="title">
        <textarea class="form-control" id="text" type="text" name="description"></textarea>
        <label>Автор</label>
        <input type="text" name="username" class="form-control" value="${(principal.name)!''}">
        <button type="submit">Создать</button>
    </div>
</form>
<div>
    <a href="/">Back to home page</a>
</div>

