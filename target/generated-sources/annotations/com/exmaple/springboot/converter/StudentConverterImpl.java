package com.exmaple.springboot.converter;

import com.exmaple.springboot.dto.StudentDto;
import com.exmaple.springboot.model.Mark;
import com.exmaple.springboot.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class StudentConverterImpl implements StudentConverter {

    @Override
    public List<StudentDto> toDto(List<Student> students) {
        if ( students == null ) {
            return null;
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( studentToStudentDto( student ) );
        }

        return list;
    }

    @Override
    public Map<StudentDto, List<Mark>> toDto(Map<Student, List<Mark>> studentWithMarkMap) {
        if ( studentWithMarkMap == null ) {
            return null;
        }

        Map<StudentDto, List<Mark>> map = new HashMap<StudentDto, List<Mark>>( Math.max( (int) ( studentWithMarkMap.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<Student, List<Mark>> entry : studentWithMarkMap.entrySet() ) {
            StudentDto key = studentToStudentDto( entry.getKey() );
            List<Mark> value = entry.getValue();
            map.put( key, value );
        }

        return map;
    }

    protected StudentDto studentToStudentDto(Student student) {
        if ( student == null ) {
            return null;
        }

        int studentId = 0;
        String fio = null;
        Character sex = null;

        studentId = student.getStudentId();
        fio = student.getFio();
        sex = student.getSex();

        StudentDto studentDto = new StudentDto( studentId, fio, sex );

        return studentDto;
    }
}
