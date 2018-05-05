public static class UntrustworthyMailWorker implements MailService {
    MailService[] services = null;
    RealMailService realService = new RealMailService();
    
    public UntrustworthyMailWorker(MailService[] services) {
        this.services = services;
    }
    
    public RealMailService getRealMailService() {
        return this.realService;
    }
    
    @Override
    public Sendable processMail(Sendable mail) {
        Sendable mmail = mail;
        
        for (MailService service : services) {
            mmail = service.processMail(mmail);
        }
        
        return realService.processMail(mmail);
    }
}

public static class Spy implements MailService {
    Logger logger = null;
    
    public Spy(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            String from = mail.getFrom();
            String to = mail.getTo();
            
            boolean cond = from.equals(AUSTIN_POWERS) || to.equals(AUSTIN_POWERS);
            if (cond == true) {
                Object[] warnLogObj = new Object[] {
                    mail.getFrom(),
                    mail.getTo(),
                    ((MailMessage)mail).getMessage()
                };
                
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", warnLogObj);
            } else {
                Object[] infoLogObj = new Object[] {
                    mail.getFrom(),
                    mail.getTo()
                };
                
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", infoLogObj);
            }
        }
        
        return mail;
    }
}

public static class Thief implements MailService {
    int minThiefCost = 0;
    int stolenValue = 0;
    
    public Thief(int minThiefCost) {
        this.minThiefCost = minThiefCost;
    }
    
    public int getStolenValue() {
        return this.stolenValue;
    }
    
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage)mail;
            Package ppackage = mailPackage.getContent();
            int price = ppackage.getPrice();
            
            if (price >= minThiefCost) {
                stolenValue += price;
                
                String packageContent = ppackage.getContent();
                Package fakePackage = new Package("stones instead of " + packageContent, 0);
                
                return new MailPackage(mail.getFrom(), mail.getTo(), fakePackage);
            }
            
            return mail;
        }
        
        return mail;
    }
}

public static class Inspector implements MailService {
    final String STONES = "stones";
    
    @Override
    public Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException {
        if (mail instanceof MailPackage) {
            String content = ((MailPackage)mail).getContent().getContent();
            boolean illegalCond = content.equals(WEAPONS) || content.equals(BANNED_SUBSTANCE);
            boolean stolenCond = content.contains(STONES);
            
            if (illegalCond == true) {
                throw new IllegalPackageException();
            }
            
            if (stolenCond == true) {
                throw new StolenPackageException();
            }
        }
        
        return mail;
    }
}

public static class StolenPackageException extends RuntimeException {
    public StolenPackageException(){} 
}

public static class IllegalPackageException extends RuntimeException {
    public IllegalPackageException(){}
}
