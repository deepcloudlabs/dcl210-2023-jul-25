package com.example.exercises;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Exercise04 {

	public static void main(String[] args) {
        Set<Name> s = new HashSet<>(1_000_000);
        s.add(new Name("Mickey", "Mouse"));

        System.out.println(
            s.contains(new Name("Mickey", "Fare"))
        );

	}

}

final class Name extends Object {
	private final String first, last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	@Override
	public int hashCode() {
		System.err.println("Name::hashCode");
		return Objects.hash(first, last);
	}

	@Override
	public boolean equals(Object obj) {
		System.err.println("Name::equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last);
	}

	
}