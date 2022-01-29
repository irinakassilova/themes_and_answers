<#import "partials/main.ftlh" as main />
<@main.renderWith scripts=["/js/main.js"]>
    <ul class="menu">
        <li class="menuLi"><a href="/">Главная</a></li>
        <#if principal??>
            <li class="menuLi"><a class="menuA" href="/profile">Личный кабинет</a></li>
            <li class="menuLi"><a href="/themes/add">Создать тему</a></li>
            <li class="menuLiReg"><form action="/logout" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>
                    <button type="submit" value="">Выйти</button>
                </form></li>
        <#else>
            <li class="menuLiLog"><button type="submit" value=""><a class="menuA" href="/login">Войти</a></button></li>
            <li class="menuLiReg"><button type="submit" value=""><a class="menuA" href="/register">Зарегистрироваться! </a></button></li>
        </#if>
    </ul>

    <h2>Темы</h2>
    <div class="flex flex-column" id="itemList">
        <#list items as listItem>
            <div class="flex flex-column flex-v-center">
                <a href="/themes/${listItem.id}">
                    <div class="flex">
                        <ul class items>
                            <li>${listItem.title}</li>
                            <li style="color: blue">${listItem.user.name}</li>
                            <li style="color: darkblue">${listItem.created}</li>
                            <li style="color: blue">ответов ${listItem.count}</li>
                        </ul>
                    </div>
                </a>
            </div>
        </#list>
    </div>

    <#include "partials/pagination.ftlh">

</@main.renderWith>