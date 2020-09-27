package BUILDER.exercice;

public class CodeBuilder
{

    protected StringBuilder buildedClass = new StringBuilder();

    public CodeBuilder(String className)
    {
        buildedClass
                .append("public ")
                .append("class ")
                .append(className)
                .append(OpeningSemicolon());

    }

    public CodeBuilder addField(String name, String type)
    {
        buildedClass
                .append(String.format("%s\tpublic ", System.lineSeparator()))
                .append(String.format("%s ",type))
                .append(String.format("%s;",name));
                //.append(String.format(";", System.lineSeparator()));

        return this;

    }

    private String OpeningSemicolon() {

        StringBuilder sb = new StringBuilder();
        return sb
                .append(String.format("%s{",System.lineSeparator()))
                .toString();

    }

    private String ClosingSemicolon() {

        StringBuilder sb = new StringBuilder();
        return sb
                .append(String.format("%s}",System.lineSeparator()))
                .toString();

    }


    @Override
    public String toString()
    {
        return buildedClass
                .append(ClosingSemicolon())
                .toString();
        // todo
    }
}

class Demo{
    public static void main(String[] args){

        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name","String")
                .addField("age","int");

        System.out.println(cb);

    }
}