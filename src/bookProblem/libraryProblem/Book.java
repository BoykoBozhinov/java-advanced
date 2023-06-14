package bookProblem.libraryProblem;

import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthor(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setAuthor(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.getTitle().compareTo(other.getTitle());

        if (result == 0) {
            result = Integer.compare(this.getYear(), other.getYear());
        }
        return result;
    }
}
