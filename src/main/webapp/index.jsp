<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br">

    <head>
        <title>Amortization Systems</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link type="text/css" rel="stylesheet" href="index.css" />
        <link type="image/svg" rel="icon" href="favicon.svg" />
    </head>

    <body>
        <form id="formulario" action="AmortizationServlet" method="get">
            <fieldset>
                <legend>Amortization System:</legend>
                <p>
                    <label for="option">Option:</label>
                    <select name="option" id="option">
                        <c:forEach var="system" items="${systems}" varStatus="status">
                            <option value="${status.index}" <c:if test="${param.option eq status.index}">selected="selected"</c:if>>${system}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><label for="principal">Principal:</label> <input type="text" name="principal" id="principal"
                        value="${param.principal}" /></p>
                <p><label for="period">Period in months:</label> <input type="text" name="period" id="period"
                        value="${param.period}" /></p>
                <p><label for="rate">Monthly interest rate:</label> <input type="text" name="rate" id="rate"
                        value="${param.rate}" /></p>
                <p><input type="submit"></p>
            </fieldset>
        </form>
        <table>
            <thead>
                <tr>
                    <th>n</th>
                    <th>Interest</th>
                    <th>Amortization</th>
                    <th>Installment</th>
                    <th>Balance</th>
                </tr>
            </thead>
            <c:if test="${schedule ne null}">
                <tbody>
                    <c:forEach var="item" items="${schedule.items}">
                        <tr>
                            <td>${item.period}</td>
                            <td><fmt:formatNumber value="${item.interest}" type="currency" /></td>
                            <td><fmt:formatNumber value="${item.amortization}" type="currency" /></td>
                            <td><fmt:formatNumber value="${item.installment}" type="currency" /></td>
                            <td><fmt:formatNumber value="${item.balance}" type="currency" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>Totals</th>
                        <td><fmt:formatNumber value="${schedule.totals.interest}" type="currency" /></td>
                        <td><fmt:formatNumber value="${schedule.totals.amortization}" type="currency" /></td>
                        <td><fmt:formatNumber value="${schedule.totals.installment}" type="currency" /></td>
                        <td><fmt:formatNumber value="${schedule.totals.balance}" type="currency" /></td>
                    </tr>                
                </tfoot>
            </c:if>
        </table>
    </body>

    </html>