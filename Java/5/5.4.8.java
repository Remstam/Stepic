public static Animal[] deserializeAnimalArray(byte[] data) {
    Animal[] animals = null;
    int length = 0;
    
    ObjectInputStream in = null;
    try {
        in = new ObjectInputStream(new ByteArrayInputStream(data));
        length = in.readInt();
        animals = new Animal[length];
        
        for (int i = 0; i < length; ++i) {
            animals[i] = (Animal)in.readObject();
        }
        
        in.close();
    } catch (Exception e) {
        throw new IllegalArgumentException(e);
    }
    
    return animals;
}
