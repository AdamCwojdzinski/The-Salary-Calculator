import {Rate} from './rate.model';

export interface Exchangerate {
  table: string;
  effectiveDate: string;
  code: string;
  rates: Rate[];
}
