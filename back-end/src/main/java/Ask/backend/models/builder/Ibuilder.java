package Ask.backend.models.builder;


import Ask.backend.models.Imodel;

public interface Ibuilder {
    public boolean comopse(String sentData) ;
    public Imodel getModel();
}
