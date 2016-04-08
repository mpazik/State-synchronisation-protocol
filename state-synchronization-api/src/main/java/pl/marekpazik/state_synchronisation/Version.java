package pl.marekpazik.state_synchronisation;

import java.util.Objects;

public final class Version {
    private final int version;

    private Version(int version) {
        this.version = version;
    }

    public Version next() {
        return new Version(version + 1);
    }

    public static Version first() {
        return new Version(1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Version version1 = (Version) o;
        return version == version1.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(version);
    }

    @Override
    public String toString() {
        return "Version{" +
                "version=" + version +
                '}';
    }
}
