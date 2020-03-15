package cn.kong.elfinder.param;

public class Node {
	private String appkey;
    private String source;
    private String alias;
    private String path;
    private String host;
    private Boolean _default;
    private String locale;
    private Constraint constraint;
    
    

    public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getHost() {
    	return host;
    }
    
    public void setHost(String host) {
    	this.host = host;
    }

    public Boolean get_default() {
        return _default;
    }

    public void set_default(Boolean _default) {
        this._default = _default;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }
}
