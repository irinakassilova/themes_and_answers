<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <div class="container">
        <div class="flex">
            <div class="flex flex-column flex-v-center">
                <div class="flex">
                    <ul>
                        <li>${theme.title}</li>
                        <li>${theme.created}</li>
                        <li>${theme.user.name}</li>

                    </ul>
                </div>
            </div>
        </div>
        <div class="flex-column">
            <p>${theme.description}</p>
            <button id="myBtn"><a href="/themes/${theme.id}" id="scroll_bottom">Ответить</a></button>
            <#list answers as answer>
                <div class="card mb-3" style="max-width: 540px; align-content: center;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <h4 class="img-fluid rounded-start">${answer.user.name}</h4>
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <p class="card-text">${answer.created}</p>
                                <p class="card-text">${answer.description}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </#list>
            <form action="/answer/add/${principal.name}" method="post">
                <p><b>Напишите ваш ответ:</b></p>
                <p><textarea rows="10" cols="45" name="text"></textarea></p>
                <p><input type="submit" value="Отправить"></p>
            </form>
            <#if _csrf??>
                <input type="hidden"
                       name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}" />
            </#if>
        </div>
        <div>
            <a href="/">Back to home page</a>
        </div>
    </div>
    <script> $(function(){
            $('#scroll_bottom').click(function(){
                $('html, body').animate({scrollTop: $(document).height() - $(window).height()}, 600);
                return false;
            });
        });</script>
</@main.renderWith>