import java.util.ArrayList;

public class EratosthenesPrimeSieve implements PrimeSieve {
    private int max = 100;
    private boolean[] primes;

    private void sieve(int max){
        this.max = max;
        boolean[] primes = new boolean[this.max + 1];

        for(int i = 0; i < max; ++i){
            primes[i] = true;
        }

        for(int i = 2;i<max; ++i){
            if(primes[i]){
                for(int j = (i*i); j<max; j = j + i){
                    primes[j] = false;
                }
            }
        }
        this.primes = primes;

    }

    @Override
    public boolean isPrime(int p) {
        sieve(p + 1);
        return primes[p];
    }

    @Override
    public void printPrimes() {
        sieve(max);
        for(int i = 2; i<primes.length;++i){
            if(primes[i]){
                System.out.println(i);
            }
        }
    }

    public void setMax(int max){
        this.max = max;
    }

    public void printAddition(int max){
        max++;
        sieve(max);

        int x = 0;
        int y = 0;
        boolean printed = false;

        for(int i = 4; i < max; i = i + 2){
            for(int j = 0; j < (max/2); ++j){
                if(primes[j]){
                    for(int k = 0; k < (max/2); ++k){
                        if(primes[k]){
                            if((k + j) == i){
                                System.out.println(i + " = " + j + " + " + k);
                                printed = true;
                                break;
                            }
                        }
                    }
                }
                if(printed){
                    printed = false;
                    break;
                }
            }
        }
    }
}
