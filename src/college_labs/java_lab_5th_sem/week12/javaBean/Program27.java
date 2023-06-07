package college_labs.java_lab_5th_sem.week12.javaBean;

import java.beans.*;

public class Program27 {

    public static class FaceBean {
        private int mMouthWidth = 90;

        //Bound
        private final PropertyChangeSupport mPcs = new PropertyChangeSupport(this);

        //Constrained
        private final VetoableChangeSupport mVcs = new VetoableChangeSupport(this);

        public int getMouthWidth() {
            return mMouthWidth;
        }

        public void
        setMouthWidth(int mw) throws PropertyVetoException {
            int oldMouthWidth = mMouthWidth;
            mVcs.fireVetoableChange("mouthWidth", oldMouthWidth, mw);
            mMouthWidth = mw;
            mPcs.firePropertyChange("mouthWidth", oldMouthWidth, mw);
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            mPcs.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            mPcs.removePropertyChangeListener(listener);
        }

        public void addVetoableChangeListener(VetoableChangeListener listener) {
            mVcs.addVetoableChangeListener(listener);
        }

        public void removeVetoableChangeListener(VetoableChangeListener listener) {
            mVcs.removeVetoableChangeListener(listener);
        }
    }
}