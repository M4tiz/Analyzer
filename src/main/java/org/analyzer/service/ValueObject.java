package org.analyzer.service;

/**
 * @author mateusz.rutski@sagiton.pl
 */
public abstract class ValueObject<T> {

    protected T domainObject;

    public ValueObject(T domainObject) {
        this.domainObject = domainObject;
    }

    /**package**/ T getDomainObject() {
        return domainObject;
    }
}
