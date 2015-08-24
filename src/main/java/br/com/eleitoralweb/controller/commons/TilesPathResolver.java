package br.com.eleitoralweb.controller.commons;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class TilesPathResolver extends DefaultPathResolver {

    @Inject
    protected TilesPathResolver(FormatResolver resolver) {
        super(resolver);
    }
	@Override
	protected String extractControllerFromName(String baseName) {
		// TODO Auto-generated method stub
		return super.extractControllerFromName(baseName);
	}
    @Override
    protected String getPrefix() {
        return "/";
    }

    @Override
    protected String getExtension() {
        return "tiles";
    }
}