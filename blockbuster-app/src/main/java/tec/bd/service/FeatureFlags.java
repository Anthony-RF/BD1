package tec.bd.service;

public class FeatureFlags {
    private boolean createMovieViaStoredProcedureEnabled = false;

    public boolean isCreateClientViaStoredProcedureEnabled() {
        return this.createMovieViaStoredProcedureEnabled;
    }
    public void setCreateClientViaStoredProcedureEnabled(boolean flag){
        this.createMovieViaStoredProcedureEnabled = flag;
    }

}
