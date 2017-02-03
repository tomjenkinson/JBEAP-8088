package ch.rp.jboss.test.project2;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

public class DummyXARessource implements XAResource {

    private int transactionTimeout;
    private String name;

    public DummyXARessource(String name) {
        this.name = name;
    }

    @Override
    public void commit(Xid arg0, boolean arg1) throws XAException {
        System.out.println("commit " + name + " xid=" + arg0);
    }

    @Override
    public void end(Xid arg0, int arg1) throws XAException {
        System.out.println("end " + name + " xid=" + arg0);
    }

    @Override
    public void forget(Xid arg0) throws XAException {
        System.out.println("forget " + name + " xid=" + arg0);
    }

    @Override
    public int getTransactionTimeout() throws XAException {
        return transactionTimeout;
    }

    @Override
    public boolean isSameRM(XAResource arg0) throws XAException {
        return true;
    }

    @Override
    public int prepare(Xid arg0) throws XAException {
        System.out.println("prepare " + name + " xid=" + arg0);
        return 0;
    }

    @Override
    public Xid[] recover(int arg0) throws XAException {
        System.out.println("recover " + name + " arg=" + arg0);
        return new Xid[0];
    }

    @Override
    public void rollback(Xid arg0) throws XAException {
        System.out.println("rollback " + name + " xid=" + arg0);

    }

    @Override
    public boolean setTransactionTimeout(int arg0) throws XAException {
        transactionTimeout = arg0;
        return true;
    }

    @Override
    public void start(Xid arg0, int arg1) throws XAException {
        System.out.println("start " + name + " xid=" + arg0);
    }

}
