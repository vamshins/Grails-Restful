<%@ page import="restservice.City" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'city.label', default: 'City')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-city" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-city" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list city">

        <g:if test="${cityInstance?.postalCode}">
            <li class="fieldcontain">
                <span id="postalCode-label" class="property-label"><g:message code="city.postalCode.label"
                                                                              default="Postal Code"/></span>

                <span class="property-value" aria-labelledby="postalCode-label"><g:fieldValue bean="${cityInstance}"
                                                                                              field="postalCode"/></span>

            </li>
        </g:if>

        <g:if test="${cityInstance?.cityName}">
            <li class="fieldcontain">
                <span id="cityName-label" class="property-label"><g:message code="city.cityName.label"
                                                                            default="City Name"/></span>

                <span class="property-value" aria-labelledby="cityName-label"><g:fieldValue bean="${cityInstance}"
                                                                                            field="cityName"/></span>

            </li>
        </g:if>

        <g:if test="${cityInstance?.countryCode}">
            <li class="fieldcontain">
                <span id="countryCode-label" class="property-label"><g:message code="city.countryCode.label"
                                                                               default="Country Code"/></span>

                <span class="property-value" aria-labelledby="countryCode-label"><g:fieldValue bean="${cityInstance}"
                                                                                               field="countryCode"/></span>

            </li>
        </g:if>

        <g:if test="${cityInstance?.dateCreated}">
            <li class="fieldcontain">
                <span id="dateCreated-label" class="property-label"><g:message code="city.dateCreated.label"
                                                                               default="Date Created"/></span>

                <span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                        date="${cityInstance?.dateCreated}"/></span>

            </li>
        </g:if>

        <g:if test="${cityInstance?.lastUpdated}">
            <li class="fieldcontain">
                <span id="lastUpdated-label" class="property-label"><g:message code="city.lastUpdated.label"
                                                                               default="Last Updated"/></span>

                <span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                        date="${cityInstance?.lastUpdated}"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: cityInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${cityInstance}"><g:message code="default.button.edit.label"
                                                                                     default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
