package semester1.practice09;

public class Practice09_32 {
    public static void main(String[] args) {
        AbstractCompressor[] compressors = {new ZipCompressor(), new UltraLzmaCompressor()};
        for (AbstractCompressor compressor : compressors) {
            System.out.printf("%s: %d байтів, стиснення %.2f%%%n", compressor,
                    compressor.estimateCompressedSize(10000), compressor.getCompressionRatio(10000));
        }
    }

    static abstract class AbstractCompressor {
        private final String algorithmName;

        public AbstractCompressor(String algorithmName) {
            this.algorithmName = algorithmName;
        }

        public abstract int estimateCompressedSize(int originalSizeBytes);

        public double getCompressionRatio(int originalSizeBytes) {
            if (originalSizeBytes < 0) {
                throw new IllegalArgumentException("Розмір має бути невід'ємним");
            }
            return originalSizeBytes == 0 ? 0.0
                    : 100.0 * (originalSizeBytes - estimateCompressedSize(originalSizeBytes)) / originalSizeBytes;
        }

        @Override
        public String toString() {
            return algorithmName;
        }
    }

    static class ZipCompressor extends AbstractCompressor {
        public ZipCompressor() {
            super("ZIP");
        }

        @Override
        public int estimateCompressedSize(int originalSizeBytes) {
            if (originalSizeBytes < 0) {
                throw new IllegalArgumentException("Розмір має бути невід'ємним");
            }
            return (int) Math.round(originalSizeBytes * 0.55);
        }
    }

    static class UltraLzmaCompressor extends AbstractCompressor {
        public UltraLzmaCompressor() {
            super("Ultra LZMA");
        }

        @Override
        public int estimateCompressedSize(int originalSizeBytes) {
            if (originalSizeBytes < 0) {
                throw new IllegalArgumentException("Розмір має бути невід'ємним");
            }
            return (int) Math.round(originalSizeBytes * 0.30) + 128;
        }
    }
}
