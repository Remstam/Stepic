private String printTextPerRole(String[] roles, String[] textLines) {
    Map<String, ArrayList<String>> temp = new HashMap<String, ArrayList<String>>();
    StringBuilder res = new StringBuilder();
        
    for (int i = 0; i < textLines.length; i++)
    {
        /*if (textLines[i] == null)
            break;*/
        	    
        int delimPos = textLines[i].indexOf(':');
        String name = textLines[i].substring(0, delimPos);
        String replic = (i+1) + ")" + textLines[i].substring(delimPos + 1, textLines[i].length());
        	
        if (temp.containsKey(name) == false)
            temp.put(name, new ArrayList<String>());
        temp.get(name).add(replic);
    }
        
    for (int i = 0; i < roles.length; i++)
    {
       	/*if (roles[i] == null)
       	    break;*/
        	
       	res.append(roles[i] + ":\n");
       	if (temp.containsKey(roles[i]))
       	{
       	    ArrayList<String> replics = temp.get(roles[i]);
       	    for (String str: replics)
       	        res.append(str + "\n");
       	}
        	
       	res.append("\n");
    }
        
    return res.toString();
}
