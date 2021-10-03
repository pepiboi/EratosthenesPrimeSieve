public class EratosthenesPrimeSieve implements PrimeSieve {
    private int max = 10;
    private boolean[] primes = new boolean[0];

    private void sieve(int max){
        boolean[] primes = new boolean[max];

        for(int i = 0; i < max; ++i){
            primes[i] = true;
        }

        for(int i = 2;i<max; ++i){
            if(primes[i] == true){

                for(int j = (i*i); j<max; j = j*i){
                    primes[j] = false;
                }

            }
        }

        this.primes = primes;

    }

    @Override
    public boolean isPrime(int p) {
        if(p>max){
            max = p;
            sieve(max);
        }
        return primes[p];
    }

    @Override
    public void printPrimes() {
        for(int i = 0; i<primes.length;++i){
            if(primes[i] == true){
                System.out.println(i);
            }
        }
    }
}
