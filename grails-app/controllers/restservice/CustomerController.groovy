package restservice

import grails.rest.RestfulController
import grails.transaction.Transactional
import groovy.time.TimeCategory
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import java.lang.invoke.MethodHandleImpl

import static org.springframework.http.HttpStatus.*
import grails.artefact.Artefact
import grails.util.GrailsNameUtils

import org.codehaus.groovy.grails.web.servlet.HttpHeaders
import org.springframework.http.HttpStatus

class CustomerController<T> extends RestfulController {
    static allowedMethods = [updateYear: "PUT"]

    def customerService

    static responseFormats = ['json', 'xml']
    CustomerController() {
        super(Customer)
    }

    /*@Transactional
    def update() {
        println "Nothing to do in update()"
        render "Nothing to do in update()"
    }*/

    /**
     * handles the request for write methods (create, edit, update, save, delete) when controller is in read only mode
     *
     * @return true if controller is read only
     */
    protected boolean handleReadOnly() {
        if(readOnly) {
            println "readonly"
            render status: HttpStatus.METHOD_NOT_ALLOWED.value()
            return true
        } else {
            return false
        }
    }

    @Transactional
    def updateYear() {
        println "Redefined update() called"
        if (handleReadOnly()) {
            println "handleReadOnly()"
            return
        }

        println params.id
        T instance = queryForResource(params.id)
        if (instance == null) {
            println "instance is null"
            transactionStatus.setRollbackOnly()
            notFound()
            return
        } else {
            print "instance is not null"
        }

        instance.properties = getObjectToBind()

        if (instance.hasErrors()) {
            print "instance has errors"
            transactionStatus.setRollbackOnly()
            respond instance.errors, view: 'edit' // STATUS CODE 422
            return
        } else {
            print "instance has no errors"
        }

        /*def map = instance.getProperties()

        map.each{ k, v -> println "${k}:${v}" }*/
        instance.putAt('dob', customerService.incrementYearByOne(instance))

        instance.save flush: true
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: "${resourceClassName}.label".toString(), default: resourceClassName), instance.id])
                redirect instance
            }
            '*' {
                response.addHeader(HttpHeaders.LOCATION,
                        g.createLink(
                                resource: this.controllerName, action: 'show', id: instance.id, absolute: true,
                                namespace: hasProperty('namespace') ? this.namespace : null))
                respond instance, [status: OK]
            }
        }
    }
}
