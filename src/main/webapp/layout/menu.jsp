<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- menu navega��o lateral -->
<c:forEach var="menu" items="${userSession.menuItens}" varStatus="contador">
        <div class="panel panel-primary">
            <div id="colGroup${contador.index}" role="tab" class="panel-heading">
                <h4 class="panel-title">
                    <a href="#colListGroup${contador.index}" aria-controls="colListGroup${contador.index}" aria-expanded="false" data-toggle="collapse">

                        <span class="glyphicon glyphicon-file"></span>
                        <c:if test="${not empty menu.url}">
                            <a href="${pageContext.request.contextPath}${menu.url}">${menu.nome}</a>
                        </c:if>
                        <c:if test="${empty menu.url}">
                            ${menu.nome}
                        </c:if>
                    </a>
                </h4>
            </div>
            <c:forEach var="itemMenu" items="${menu.recursosFilhos}" varStatus="contadorItem">
                <div role="tabpanel" class="panel-collapse collapse" id="colListGroup${contador.index}" aria-expanded="false">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <c:if test="${not empty itemMenu.url}">
                                <a href="${pageContext.request.contextPath}${itemMenu.url}">${itemMenu.nome}</a>
                            </c:if>
                            <c:if test="${empty itemMenu.url}">
                                ${itemMenu.nome}
                            </c:if>

                        </li>
                    </ul>
                    <div class="panel-footer"></div>
                </div>
            </c:forEach>
        </div>
 </c:forEach>
