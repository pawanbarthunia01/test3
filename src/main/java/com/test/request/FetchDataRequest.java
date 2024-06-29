package com.test.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FetchDataRequest {

    private String filter;
    private String data;
}
