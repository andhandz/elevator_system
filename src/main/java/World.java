public class World {
    public static void main(String[] args){
        int[] arg = option_parser.parse(args);
        simulation_engine engine = new simulation_engine(arg[0],arg[1],arg[2]);
        engine.run();
    }
}
