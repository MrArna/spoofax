package org.metaborg.spoofax.core.unit;

import org.apache.commons.vfs2.FileObject;
import org.metaborg.core.unit.IUnit;
import org.metaborg.core.unit.IUnitContrib;

public class SpoofaxUnitWrapper implements IUnit {
    public final SpoofaxUnit unit;


    public SpoofaxUnitWrapper(SpoofaxUnit unit) {
        this.unit = unit;
    }


    @Override public FileObject source() {
        return unit.source();
    }

    @Override public boolean detached() {
        return unit.detached();
    }

    @Override public IUnitContrib unitContrib(String id) {
        return unit.unitContrib(id);
    }

    @Override public Iterable<IUnitContrib> unitContribs() {
        return unit.unitContribs();
    }


    public void addUnitContrib(IUnitContrib contrib) {
        unit.addUnitContrib(contrib);
    }
}
